<template>
  <div id="register" class="text-center">
    <Header />
    <div id="registration-container">
      <form @submit.prevent="register" id="reg-form">
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="form-input-group">
          
          <input
            type="text"
            id="username"
            v-model="user.username"
            placeholder="Username"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <input
            type="password"
            id="password"
            v-model="user.password"
            placeholder="Password"
            required
          />
        </div>
        <div class="form-input-group">
          <input
            type="password"
            id="confirmPassword"
            v-model="user.confirmPassword"
            placeholder="Confirm Password"
            required
          />
        </div>
        <button type="submit">Create Account</button>
        <p>
          <router-link :to="{ name: 'login' }"
            >Already have an account? Log in.</router-link
          >
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import Header from "../components/Header.vue";
export default {
  name: "register",
  components: {
    Header,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        //can change this to choose their role from user to admin
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            // if (response.status == 201) {
            this.$router.push({
              //this is where we change the path after registering
              path: "/customer-info",
              query: { registration: "success" },
            });
            // }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
#registration-container{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 100%;
  background-image: url('../assets/pizza-pi.gif');
  background-size:contain;
  padding: 50px;
}
#reg-form{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 15px;
  width: 25vw;
  background-color: #64379f;
  border-radius: 15px;
  border: solid 3px #75e8e7;
}
</style>
