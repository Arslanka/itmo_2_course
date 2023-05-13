import axios from 'axios';

const NEWTONS_METHOD_URL = 'http://localhost:8080/newtons';

class NewtonsMethodService {

    solveNewtonsMethodResult(equationNumber, left, right, eps) {
        return axios.post(NEWTONS_METHOD_URL + '/solve', {
            equation_number: equationNumber,
            segment: {
                left: left,
                right: right,
            },
            eps: eps
        });
    }
}

export default new NewtonsMethodService();