import React from 'react';
import MenuIcon from '@material-ui/icons/BubbleChart';
function Header() {
	return (
		<header style={header}>
			<MenuIcon />
			<h2>Jasypt Encryption Decryption</h2>
			<p></p>
		</header>
	);
}

const header = {
	background: "#3b3e66",
	color: "#fff",
	padding: "10px",
	display: "flex",
	alignItems: 'center',
	justifyContent: 'space-between',

}
export default Header;