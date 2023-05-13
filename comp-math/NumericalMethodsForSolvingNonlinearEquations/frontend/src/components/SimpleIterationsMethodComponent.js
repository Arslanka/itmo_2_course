import React, {Component} from 'react';
import SimpleIterationsMethodService from '../services/SimpleIterationsMethodService';
import SystemPlot from './SystemPlot';

class SimpleIterationsMethodComponent extends Component {
    state = {
        equation_number: '1',
        solution: {},
        left: '',
        right: '',
        eps: '',
    };

    handleSubmit = event => {
        event.preventDefault();
        SimpleIterationsMethodService.solveSimpleIterationsMethodResult(this.state.equation_number, this.state.left, this.state.right, this.state.eps)
            .then((
                    res
                ) => {
                    console.log(res.data);
                    this.setState({
                            solution: res.data
                        }
                    );
                }
            );
    };

    handleChangeEquationNumber = event => {
        this.setState({equation_number: event.target.value});
    };

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

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label> System:
                        <nav>
                            <ul>
                                <li>f1(x1,x2) = 0.1x1^2 + x1 + 0.2x2^2 - 0.3 = 0</li>
                                <li>f2(x1, x2) = 0.2x2^2 + x2 + 0.1x1x2 - 0.7 = 0</li>
                            </ul>
                        </nav>
                        <nav><select value={this.state.equation_number.value} onChange={this.handleChangeEquationNumber}
                            title="Choose the equation number">
                            <option value="1">1</option>
                        </select>
                            <input type="text" placeholder="leftSegment"
                                pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.left.value}
                                onChange={this.handleChangeSegmentLeft} />
                            <input type="text" placeholder="rightSegment"
                                pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.right.value}
                                onChange={this.handleChangeSegmentRight} />
                            <input type="text" placeholder="eps"
                                pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.eps.value}
                                onChange={this.handleChangeEps} />
                        </nav>
                    </label>
                    <button type="submit"> submit</button>
                </form>
                <table className="table">
                    <thead>
                    <th>Number of Iterations</th>
                    <th>Roots</th>
                    <th>Appoxes</th>
                    </thead>
                    <tbody>
                    <td>{this.state.solution.numberOfIterations}</td>
                    <td>{(this.state.solution.roots !== undefined) ? this.state.solution.roots.join(',\n') : ''}</td>
                    <td>{(this.state.solution.approxes !== undefined) ? this.state.solution.approxes.map(pair => '(' + pair.first + ', ' + pair.second + ')' + ', ') : ''}</td>
                    </tbody>
                </table>
                <SystemPlot f1={"x^2 + 1"} f2={"-x - 1"}/>
            </div>
        );
    }
}


export default SimpleIterationsMethodComponent;