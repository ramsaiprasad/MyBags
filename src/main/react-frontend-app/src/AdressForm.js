import React, { Component } from 'react'
import TextField from'@mui/material/TextField'
import { Icon } from '@mui/material'
import Button from '@mui/material/Button'
import './App.css';
export default class AdressForm extends Component {
  render() {
    return (
    <div  className='mainContainer'>
      <div className='devContainer'>AdressForm</div><br></br>
      <div>
       <label>VehicalNumber:</label><br/>
        <TextField type={"text"} placeholder="enter username"><Icon>
            </Icon></TextField><br/><br/>
       <TextField type={"password"} placeholder="enter password"></TextField><br/><br></br>
        <Button variant='contained'>Submit</Button>
      </div>
      </div>
    )
  }
}
