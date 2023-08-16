<template>
  <div id="register" class="text-center">
    <Header />
    <div id="registration-container">
      <form @submit.prevent="register" id="reg-form">
        <h1>Who Are You, Really?</h1>
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
        <button type="submit">Join Our Pizza Empire</button>
        <p>
          <router-link id="HasAccount" :to="{ name: 'Login' }"
            >Already Have An Account? Log In.</router-link
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
  height: 275px;
  align-items: center;
  flex-direction: column;
  padding: 15px;
  /* width: 40vw; */
  border-radius: 15px;
  color: #75e8e7;
  background-color: #27104e;
  border: ridge 3px #75e8e7;
  border-radius: 25px;
  font-family: monospace;
  text-shadow: 1px 1px #f31b83;
}
#HasAccount {
   color: #75e8e7;
}
button{
  background-image: linear-gradient(231deg,#e982df,#2099ff);
  margin: 5px;
  font-family: fantasy;
  font-size: 12pt;
  letter-spacing: 2pt;
  color: #492586;
  font-weight: lighter;
  text-shadow: 3px 2px #75e8e7;
  padding: 10px;
}
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 4px 3px #492586;
}
h1 {
  margin-bottom: 30px;
}
#confirmPassword {
  margin-bottom: 10px;
}
p {
  padding-bottom: 15px;
}
</style>
