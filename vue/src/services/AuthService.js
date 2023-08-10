import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  //todo make post for customer 
  setUserInfo(user){
    return axios.post('/customers/customer-info', user);
  }

}
