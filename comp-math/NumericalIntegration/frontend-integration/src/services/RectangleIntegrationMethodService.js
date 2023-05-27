import axios from 'axios';

const RECTANGLE_INTEGRATION_METHOD_URL = 'http://localhost:8080/rectangle-integration';

class RectangleIntegrationMethodService {

    solveByRectangleIntegrationMethod(equationNumber, left, right, partition, accuracy, modification) {
        return axios.post(RECTANGLE_INTEGRATION_METHOD_URL + '/solve', {
            number_of_function: equationNumber,
            integration_limits: {
                left: left,
                right: right,
            },
            partition: partition,
            accuracy: accuracy,
            modification: modification
        });
    }
}

export default new RectangleIntegrationMethodService();