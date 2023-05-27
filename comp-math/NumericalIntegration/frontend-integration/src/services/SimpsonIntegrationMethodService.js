import axios from 'axios';

const SIMPSON_INTEGRATION_METHOD_URL = 'http://localhost:8080/simpson-integration';

class SimpsonIntegrationMethodService {

    solveBySimpsonIntegrationMethod(equationNumber, left, right, partition, accuracy) {
        return axios.post(SIMPSON_INTEGRATION_METHOD_URL + '/solve', {
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

export default new SimpsonIntegrationMethodService();