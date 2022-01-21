import React, { Component } from 'react';
import PropTypes from "prop-types";

const searchAlgo = ['Sydney', 'Melbourne', 'Brisbane',
	'Adelaide', 'Perth', 'Hobart'];

class EncryptDecrypt extends Component {
	constructor(props) {
		super(props);
		this.state = {
			plainText: '',
			algorithm: '',
			encryptionType: '',
			secretKey: ''
		}
		//If you dont use arrow function you will have to manually bind like this
		//If you dont bind you wont be able to access items in the state of this component because it wont be recognised in lifecycle
		//this.onChange = this.onChange.bind(this);
		this.onSubmit = this.onSubmit.bind(this);
	}

	onChange = (e) => {
		//This is what you do for individual target
		//this.setState({name:e.target.value});
		//But if you have plenty
		this.setState({ [e.target.name]: e.target.value })
	}

	onSubmit(e) {
		e.preventDefault();
		//Copying state object to newUser
		let newEncryptDecrypt = this.state;
		this.props.addUser(newEncryptDecrypt);
		//Resetting the fields
		this.setState({
			plainText: '',
			algorithm: '',
			encryptionType: '',
			secretKey: ''
		});
	}

	render() {
		return (
			<form onSubmit={this.onSubmit}>
				<div style={mainComponent}>
					<h4>Jayspt Online Encryption</h4>

					<input
						type="text"
						name="plainText"
						placeholder="Enter plain text to Encrypt"
						style={leftInput}
						value={this.state.plainText}
						onChange={this.onChange}
					/>

					<br />
					<input
						type="text"
						name="algorithm"
						placeholder="Algorithm"
						style={leftInput}
						value={this.state.algorithm}
						onChange={this.onChange}
					/>

					<br />
					<input
						type="text"
						name="secretKey"
						placeholder="Secret Key"
						style={leftInput}
						value={this.state.secretKey}
						onChange={this.onChange}
					/>

					<br />
				</div>
				<input
					type="submit"
					value="Submit"
					className="btn"
				/>
				<br />
				<div>
					<input
						type="text"
						name="encryptedText"
						placeholder="Encrypted Text"
						style={leftInput}
						value={this.state.secretKey}
						onChange={this.onChange}
					/>
				</div>

			</form>
		)
	}
}

const mainComponent = {
	//display: 'flex',
	alignItems: 'center',
	//justifyContent: 'space-between',
	color: "#fff",
}

const leftInput = {
	flex: '5',
	padding: '5px',
	margin: '10px 10px 0px 0px',
}

EncryptDecrypt.propTyoes = {
	addUser: PropTypes.func.isRequired,
}

export default EncryptDecrypt;