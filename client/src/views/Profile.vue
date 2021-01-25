<template>
  <div class="container">
<!--    <header class="jumbotron">-->
<!--      <h3>-->
<!--        <strong>{{currentUser.username}}</strong> Profile-->
<!--      </h3>-->
<!--    </header>-->

    <div class="row">
      <div class="column left" style="background-color:#aaa;">
        <h2>Username: {{currentUser.username}}</h2>
        <img class="imgs" alt="photo.jpg" :src="currentUser.photo"/>

<!--        <form ref="uploadForm"  @submit.prevent="submit">-->
<!--          <input type="file" ref="uploadPhoto" @change="onPhotoUpload()" />-->
<!--          <input type="button" @click="startupload" name="Upload" value=" Upload "/>-->
<!--        </form>-->

      </div>
      <div class="column middle" style="background-color:#bbb;">
        <h2>Student information</h2> <br>

        <div class="middleText">
          <p class="v-profile-id">Unique identity: {{currentUser.id}}</p>
          <p class="v-profile-email">Email address: {{currentUser.email}}</p>

          <form ref="uploadForm"  @submit.prevent="submit">
            <input type="file" ref="uploadImage" @change="onImageUpload()"/>
            <input type="button" @click="startUpload" name="Upload" value=" Upload "/>
          </form>
<!--          <p class="v-profile-phone">Phone number: {{currentUser.phone}}</p>-->
        </div>


      </div>
      <div class="column right" style="background-color:#ccc;">
        <h2>Links</h2> <br>

        <router-link :to="{name: 'newsPage'}">
          <div class="v-profile-link-to-news">News page</div>
        </router-link>

      </div>
      <p class="v-profile-name">Token:{{currentUser.accessToken}}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Profile',
  data: () => ({
    formData: null,
    id: '',
    username: '',
    password: '',
    email: ''
  }),
  methods: {

    onImageUpload() {
        let file = this.$refs.uploadImage.files[0];
        this.formData = new FormData();
        this.formData.append("file", file);
        this.formData.append("id", JSON.parse(localStorage.getItem('user')).id);
    },

    startUpload() {
      let user = JSON.parse(localStorage.getItem('user'));
      axios({
        url: 'https://secure-app-class.herokuapp.com/api/test/photo',
        method: 'POST',
        data: this.formData,
        headers: {
          Accept: 'application/json',
          'Content-Type': 'multipart/form-data',
          'Authorization': 'Bearer '.concat(user.accessToken)
        },
      }).then(response => {
        /* eslint-disable no-console */
        console.log(JSON.stringify(response.data));
        /* eslint-enable no-console */
      })
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.imgs {
  height: 180px;
  width: 180px;
}

.left {
  text-align: left;
}

.middleText {
  text-shadow: #2c3e50;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 280px;
  text-align: left;
}

.leftText {
  text-shadow: #2c3e50;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 280px;
  text-align: center;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 60px;
  height: 550px; /* Should be removed. Only for demonstration */
}

.left, .right {
  width: 25%;
}

.middle {
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>