import axios from "axios";

export default {
    getCustomerInfo(id){
        return axios.get('',id)
    }
}