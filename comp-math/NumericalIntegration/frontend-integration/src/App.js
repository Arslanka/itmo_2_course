import './App.css';
import React from 'react';
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import RectangleIntegrationMethodComponent from './components/RectangleIntegrationMethodComponent';
import TrapezoidIntegrationMethodComponent from './components/TrapezoidIntegrationMethodComponent';
import SimpsonIntegrationMethodComponent from './components/SimpsonIntegrationMethodComponent';

class App extends React.Component {
    render() {
        return (
            <Router>
                <div className="App">
                    <label>
                        Pick up the method:
                    </label>
                    <nav>
                        <li><Link to="/">Home</Link></li>
                        <li><Link to="/rectangle-integration">Rectangle integration method</Link></li>
                        <li><Link to="/trapezoid-integration">Trapezoid integration method</Link></li>
                        <li><Link to="/simpson-integration">Simpson integration method</Link></li>
                    </nav>
                    <Routes>
                        <Route path="/rectangle-integration" exact
                            element={<RectangleIntegrationMethodComponent />}></Route>
                        <Route path="/trapezoid-integration" exact
                            element={<TrapezoidIntegrationMethodComponent />}></Route>
                        <Route path="/simpson-integration" exact
                            element={<SimpsonIntegrationMethodComponent />}></Route>
                    </Routes>
                </div>
            </Router>
        );
    }
}

export default App;