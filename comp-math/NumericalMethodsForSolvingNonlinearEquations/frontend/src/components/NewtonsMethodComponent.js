import React, {Component} from 'react';
import NewtonsMethodService from '../services/NewtonsMethodService';
import FunctionPlot from './FunctionPlot';


class NewtonsMethodComponent extends Component {
    state = {
        equation_number: '1',
        solution: {},
        left: '',
        right: '',
        eps: '',
        f: (x) => (x * x * x - x + 4),
    };

    handleSubmit = event => {
        event.preventDefault();
        NewtonsMethodService.solveNewtonsMethodResult(this.state.equation_number, this.state.left, this.state.right, this.state.eps)
            .then((
                    res
                ) => this.setState({
                        solution: res.data
                    }
                )
            );
    };

    handleChangeEquationNumber = event => {
        this.setState({equation_number: event.target.value});
        if (event.target.value === '1') {
            this.setState({f: (x) => (x * x * x - x + 4)});
        } else if (event.target.value === '2') {
            this.setState({f: (x) => Math.pow(2, x) - 1});
        }
    }

    handleChangeSegmentLeft = event => {
        this.setState({
                left: event.target.value
            }
        );
    };

    handleChangeSegmentRight = event => {
        this.setState({
                right: event.target.value
            }
        );
    };

    handleChangeEps = event => {
        this.setState({
                eps: event.target.value
            }
        );
    };

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label> Equation number:
                        <nav>
                            <ul>
                                <li>x^3 - x + 4 = 0</li>
                                <li>2^x - 1</li>
                            </ul>
                        </nav>
                        <nav><select value={this.state.equation_number.value} onChange={this.handleChangeEquationNumber}
                            title="Choose the equation number">
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                            <input type="text" placeholder="leftSegment" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$" value={this.state.left.value}
                                onChange={this.handleChangeSegmentLeft} />
                            <input type="text" placeholder="rightSegment" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.right.value}
                                onChange={this.handleChangeSegmentRight} />
                            <input type="text" placeholder="eps" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$" value={this.state.eps.value}
                                onChange={this.handleChangeEps} />
                        </nav>

                    </label>
                    <button type="submit"> submit</button>
                </form>
                <table className="table">
                    <thead>
                    <th>Number of Iterations</th>
                    <th>Root</th>
                    <th>Result</th>
                    </thead>
                    <tbody>
                    <td>{this.state.solution.numberOfIterations}</td>
                    <td>{this.state.solution.root}</td>
                    <td>{this.state.solution.result}</td>
                    </tbody>
                </table>
                <FunctionPlot f={this.state.f} range={{ x: [this.state.left, this.state.right], y: [-10, 10] }} />
            </div>
        );
    }
}


export default NewtonsMethodComponent;