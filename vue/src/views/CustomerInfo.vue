<template>
    <div>
        <AP-header />
        <div id="info">
            <!-- TODO make method for submit -->
            <form v-on:submit.prevent="createCustomer()">
                <div>
                    <label for="first-name">First Name</label>
                    <input type="text" id="first-name" name="first-name" v-model="customer.firstName" required autofocus/>
                </div>
                <div>
                    <label for="last-name">Last Name</label>
                    <input type="text" id="last-name" name="last-name" v-model="customer.lastName" required autofocus/>
                </div>
                <div>
                    <label for="street-address">Street Address</label>
                    <input type="text" id="street-address" name="street-address" v-model="customer.streetAddress" required autofocus/>
                </div>
                <div>
                    <label for="city">City</label>
                    <input type="text" id="city" name="city" v-model="customer.city" required autofocus/>
                </div>
                <div>
                    <label for="phone-number">Phone Number</label>
                    <input type="text" id="phone-number" name="phone-number" v-model="customer.phoneNumber" required autofocus/>
                </div>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</template>

<script>
import APHeader from '../components/APHeader.vue'
import AuthService from '../services/AuthService';


export default {
    components:{
        APHeader,
    },
    name: 'CustomerInfo',
    data(){
        return {
            customer: {
                firstName: '',
                lastName: '',
                streetAddress: '',
                city: '',
                phoneNumber: ''
            }
        };
    },
    methods: {
        createCustomer(){
            AuthService.setUserInfo(this.customer).then((response)=>{
                console.log(response.data);
            });
        }

    }

}
</script>

<style>

</style>