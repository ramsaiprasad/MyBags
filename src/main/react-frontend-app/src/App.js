
import './App.css';
import Signin from './Signin';
import ResponsiveAppBar from './ResponsiveAppBar'
import Login from './Login';
import {
  BrowserRouter as Router,
Routes,
  Route
} from "react-router-dom";

import { Container, Typography, Box, Stack, Grid, Button } from "@mui/material";
import ViewData from './ViewData';

import SubmitData from './SubmitData';




import { ThemeProvider } from "@mui/system";
import VehicalData from './VehicalData';
import ViewVehicalData from './ViewVehicalData';
import ViewByVehical from './ViewByVehical';
import ViewByDates from './ViewByDates';

function App() {
  return (
  <div>
    
      
       <ResponsiveAppBar /> 
      <Router>
      <Routes>
        
        <Route path="/signin" element={<Signin />} />
        <Route path="/login" element={<Login />} />
        <Route path="/viewData" element={<ViewData />} />
        <Route path="/submitData" element={<SubmitData />} />
        <Route path="/vehicalData" element={<ViewVehicalData />} />
        <Route path="/searchByVehical" element={<ViewByVehical />} />
        <Route path="/viewByDates" element={<ViewByDates />} />
       
      </Routes>
      </Router>
      
      
    </div>
  );
}

export default App;
