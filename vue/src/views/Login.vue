<template>
  <div id="login">
    <AP-header />

    <div id="log-in-container">
      <form @submit.prevent="login">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div id="input-container">
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
          <button type="submit">Sign in</button>
        </div>
        
        <p>
          <router-link :to="{ name: 'register' }"
            >Need an account? Sign up.</router-link
          >
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import APHeader from "../components/APHeader.vue";

export default {
  name: "login",
  components: {
    APHeader,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            //different router if has admin role
            if (response.data.user.authorities[0].name === "ROLE_ADMIN") {
              this.$router.push({ name: "AdminHome" });
            } else {
              this.$router.push("/");
            }
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
h1 {
  color: #27104e;
  text-align: center;
}
.form-input-group {
  margin-bottom: 1rem;
}
#input-container{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 15px;
  height: 150px;
  background-color: #64379f;
  border-radius: 15px;
   border: solid 3px #75e8e7;
}
label {
  margin-right: 0.5rem;
  color: #27104e;
  background-color: #ddacf5;
  border-radius: 10px;
  padding: 5px;
  margin: 5px;
  border: solid black 1px;
}
#log-in-container {
  background-image: url("../assets/cat-dj.gif");
  background-size: 50%;

  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 400px;
}
</style>