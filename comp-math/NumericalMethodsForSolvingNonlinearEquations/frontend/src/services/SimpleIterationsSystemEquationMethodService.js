import axios from 'axios';

const SIMPLE_ITERATIONS_METHOD_URL = 'http://localhost:8080/simple-iterations/equation';

class SimpleIterationsEquationMethodService {

    solveSimpleIterationsEquationMethodResult(equationNumber, left, right, eps) {
        return axios.post(SIMPLE_ITERATIONS_METHOD_URL + '/solve', {
            equation_number: equationNumber,
            segment: {
                left: left,
                right: right,
            },
            eps: eps
        });
    }
}

export default new SimpleIterationsEquationMethodService();