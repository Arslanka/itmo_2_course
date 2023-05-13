import './App.css';
import React from 'react';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import HalfDivisionMethodComponent from './components/HalfDivisionMethodComponent';
import NewtonsMethodComponent from './components/NewtonsMethodComponent';
import SimpleIterationsMethodComponent from './components/SimpleIterationsMethodComponent';
import SimpleIterationsEquationMethodComponent from './components/SimpleIterationsEquationMethodComponent';


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
                        <li><Link to="/half-division">Half-Division method</Link></li>
                        <li><Link to="/newtons">Newtons method</Link></li>
                        <li><Link to="/simple-iterations/equation">Simple iteration(equation) method</Link></li>
                        <li><Link to="/simple-iterations/system">Simple iteration(system) method</Link></li>
                    </nav>
                    <Route path="/half-division" component={HalfDivisionMethodComponent}></Route>
                    <Route path="/newtons" component={NewtonsMethodComponent}></Route>
                    <Route path="/simple-iterations/equation"
                        component={SimpleIterationsEquationMethodComponent}></Route>
                    <Route path="/simple-iterations/system" component={SimpleIterationsMethodComponent}></Route>
                </div>
            </Router>
        );
    }
}

export default App;
