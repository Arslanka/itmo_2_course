import axios from 'axios';

const HALF_DIVISION_METHOD_URL = 'http://localhost:8080/half-division';

class HalfDivisionMethodService {

    solveHalfDivisionMethodResult(equationNumber, left, right, eps) {
        return axios.post(HALF_DIVISION_METHOD_URL + '/solve', {
            equation_number: equationNumber,
            segment: {
                left: left,
                right: right,
            },
            eps: eps
        });
    }
}

export default new HalfDivisionMethodService();