import React, {Component} from 'react';
import inputInfo from "../input-info/inputInfo";
import PropTypes from "prop-types";
class CryptText extends Component{

    render() {
        return this.props.CryptText.map((input) =>(
           <inputInfo input={input} key={input.id} removeinput = {this.props.removeinput}/>
        ));
    }
}

//PropTypes
CryptText.propTypes = {
    CryptText:PropTypes.array.isRequired
}
export default CryptText;