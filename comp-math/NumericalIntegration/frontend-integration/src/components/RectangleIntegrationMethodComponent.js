import React, {Component, useState} from 'react';
import RectangleIntegrationMethodService from '../services/RectangleIntegrationMethodService';
import Modal from './Modal';

class RectangleIntegrationMethodComponent extends Component {

    state = {
        equation_number: '1',
        left: '1',
        right: '2',
        partition: 4,
        accuracy: '0.01',
        modification: 'LEFT',

        solution: {},
        text: '',
        show_modal: false
    };


    handleSubmit = event => {
        event.preventDefault();
        if (this.state.left >= this.state.right) {
            this.setState({
                    show_modal: true,
                    text: 'Left should be lower than right'
                }
            );
            return;
        }
        RectangleIntegrationMethodService.solveByRectangleIntegrationMethod(this.state.equation_number, this.state.left, this.state.right, this.state.partition, this.state.accuracy, this.state.modification)
            .then((
                    res
                ) => this.setState({
                        solution: res.data,
                        show_modal: res.data.message != null,
                        text: res.data.message
                    }
                )
            );
    };

    handleChangeSegmentLeft = event => {
        this.setState({
                left: event.target.value
            }
        );
    };

    handleChangeEquationNumber = event => {
        this.setState({
                equation_number: event.target.value
            }
        );
    };

    handleChangeSegmentRight = event => {
        this.setState({
                right: event.target.value
            }
        );
    };


    handleChangePartition = event => {
        this.setState({
                partition: event.target.value
            }
        );
    };

    handleChangeAccuracy = event => {
        this.setState({
                accuracy: event.target.value
            }
        );
    };

    handleChangeModification = event => {
        this.setState({
                modification: event.target.value
            }
        );
    };

    handleChangeToggle = () => {
        this.setState({
                show_modal: !this.state.show_modal
            }
        );
    };

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label> Equation number:
                        <nav>
                            <li>f(x) = x^2</li>
                            <li>f(x) = sin(x)</li>
                        </nav>
                        <nav><select value={this.state.equation_number.value} onChange={this.handleChangeEquationNumber}
                            title="Choose the equation number">
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                            <input type="text" placeholder="leftSegment" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.left.value}
                                onChange={this.handleChangeSegmentLeft} />
                            <input type="text" placeholder="rightSegment"
                                pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.right.value}
                                onChange={this.handleChangeSegmentRight} />
                            <input type="text" placeholder="partition" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.partition}
                                onChange={this.handleChangePartition} />
                            <input type="text" placeholder="accuracy" pattern="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$"
                                value={this.state.accuracy.value}
                                onChange={this.handleChangeAccuracy} />
                        </nav>
                        <nav><select value={this.state.modification.value} onChange={this.handleChangeModification}
                            title="Choose the modification">
                            <option value="LEFT">LEFT</option>
                            <option value="MIDDLE">MIDDLE</option>
                            <option value="RIGHT">RIGHT</option>
                        </select>
                        </nav>
                    </label>
                    <button type="submit"> submit</button>
                </form>
                <table className="table">
                    <thead>
                    <th>Integration result</th>
                    <th>Partition number</th>
                    </thead>
                    <tbody>
                    <td>{this.state.solution.integration_result}</td>
                    <td>{this.state.solution.partition}</td>
                    </tbody>
                </table>
                <Modal show={this.state.show_modal} onCloseButtonClick={this.handleChangeToggle}
                    text={this.state.text} />
            </div>
        );
    }
}

export default RectangleIntegrationMethodComponent;