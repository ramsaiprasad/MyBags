import React, { Component } from 'react'
import Axios from 'axios'
import { Button } from '@mui/material';
export default class Signin extends Component {
    constructor(prop)
    {
        super(prop);
        this.state={
            message:''
        }
    }

    componentDidMount()
    {
        this.getDataFromSpringBoot();
    }
    getDataFromSpringBoot=()=>
    {
        Axios.get('http://localhost:8090/api/test/getTestData').then((res)=>
        {
            this.setState({message:res.data})
            console.log(res.data)
        })
    }
  render() {
    return (
      <div>
        <h1>Signin Page from React App</h1>
        
        <p>
            {this.state.message}
            <Button variant="outlined" href='/login'>Go to Login</Button>
        </p>

      </div>
    )
  }
}
