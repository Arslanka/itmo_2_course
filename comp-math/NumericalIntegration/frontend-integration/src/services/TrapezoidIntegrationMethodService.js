import axios from 'axios';

const TRAPEZOID_INTEGRATION_METHOD_URL = 'http://localhost:8080/trapezoid-integration';

class TrapezoidIntegrationMethodService {

    solveByTrapezoidIntegrationMethod(equationNumber, left, right, partition, accuracy) {
        return axios.post(TRAPEZOID_INTEGRATION_METHOD_URL + '/solve', {
            number_of_function: equationNumber,
            integration_limits: {
                left: left,
                right: right,
            },
            partition: partition,
            accuracy: accuracy,
        });
    }
}

export default new TrapezoidIntegrationMethodService();