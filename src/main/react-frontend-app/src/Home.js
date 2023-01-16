import React, { Component } from 'react'
import AddressForm from './AdressForm'
export default class  extends Component {
  render() {
    return (
      <div>
        <div>
           <AddressForm />
        </div>
        <a href='/signin'>click</a>
      </div>
      
    )
  }
}
