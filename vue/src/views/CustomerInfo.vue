<template>
    <div>
        <div id="info">
            <form action="">
                <div>
                    <label for="first-name">First Name</label>
                    <input type="text" id="first-name" name="first-name"/>
                </div>
                <div>
                    <label for="last-name">Last Name</label>
                    <input type="text" id="last-name" name="last-name">
                </div>
                <div>
                    <label for="street-address">Street Address</label>
                    <input type="text" id="street-address" name="street-address"/>
                </div>
                <div>
                    <label for="city">City</label>
                    <input type="text" id="city" name="city">
                </div>
                <div>
                    <label for="phone-number">Phone Number</label>
                    <input type="text" id="phone-number" name="phone-number">
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
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

    }

}
</script>

<style>

</style>