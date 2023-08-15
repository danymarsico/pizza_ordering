<template>
  <div id="login">
    <Header />

    <div id="log-in-container">
      <audio id="my_audio" controls>
          <source :src="audioPath" type="audio/mpeg" />
        </audio>
      <form @submit.prevent="login">
        
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div id="input-container">
          <h1>Let's Get This Party Started</h1>
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
            <div>
            <button type="submit">Transcend</button>
            </div>
            <p>
              <router-link id="signUp" :to="{ name: 'Register' }"
                >Need an account? Register now!</router-link
              >
            </p>
            
          </div>
          
          
        </div>

        
      </form>
    </div>
  </div>
</template>

<script scoped>
import authService from "../services/AuthService";
import Header from "../components/Header.vue";

export default {
  name: "login",
  components: {
    Header,
  },
  data() {
    return {
      audioPath: require("@/assets/partyrock.mp3"),
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  mounted() {
    window.onload = function () {
      document.getElementById("my_audio").play();
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
  color: #75e8e7;
  font-family: monospace;
  text-shadow: 1px 1px #f31b83;
  text-align: center;
}
.form-input-group {
  margin-bottom: 1rem;
  text-align: center;
}
#input-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 15px;
  height: 200px;
  background-color: #27104e;
  border-radius: 25px;
  margin: 20px;
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
  flex-direction: column;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 600px;
}
#signUp {
  color: #75e8e7;
  font-family: monospace;
  text-shadow: 1px 1px #f31b83;
  text-align: center;
}
button{
  background-image: linear-gradient(231deg,#e982df,#2099ff);
  margin-top: 20px;
  font-family: fantasy;
  font-size: 12pt;
  letter-spacing: 2pt;
  color: #492586;
  font-weight: lighter;
  text-shadow: 3px 2px #75e8e7;
  padding: 8px;
}
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 4px 3px #492586;
}

</style>