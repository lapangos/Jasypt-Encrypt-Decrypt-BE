import React, { Component, useCallback } from "react";
import ReactDOM from "react-dom";
import Header from '../../../frontend/src/components/layouts/Header';
import EncryptDecrypt from '../../../frontend/src/components/encrypt-decrypt/EncryptDecrypt';
import axios from "axios";

export class App extends Component {

	render() {
		return (
			<div className="container" style={container}>
				<Header />
				<EncryptDecrypt addUser={this.addUser} />
			</div>
		);
	}
}

const container = {
	backgroundColor: "#3b3e66",
	width: '1536px',
	height: '713px',

}

export default App;

ReactDOM.render(<App />, document.querySelector("#app"));