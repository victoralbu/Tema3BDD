<h1 align="center" ><img height="50" src="https://thumbs4.imagebam.com/87/5e/59/MEIEVY5_t.png" width="50"/>  Setup  <img height="50" src="https://thumbs4.imagebam.com/87/5e/59/MEIEVY5_t.png" width="50"/></h1>

---

<br/>
<br/>

<h2 align="center"><img height="70" width="70" src="https://thumbs4.imagebam.com/31/74/aa/MEIEV7T_t.png" alt="make.png"/>Make<img height="70" width="70" src="https://thumbs4.imagebam.com/31/74/aa/MEIEV7T_t.png" alt="make.png"/> </h2>

<br/>

<ul align="center">

  ### `sudo apt install make`
  ### `sudo apt install build-essential`

</ul>

---

<br/>

<h2 align="center"><img height="50" src="https://thumbs4.imagebam.com/38/22/19/MEIEVB4_t.png" width="75"/>Docker<img height="50" src="https://thumbs4.imagebam.com/38/22/19/MEIEVB4_t.png" width="75"/></h2>

<br/>

<ul align="center">

  #### `sudo apt-get remove docker docker-engine docker.io containerd runc`
  #### `sudo apt-get update`
  ####  `sudo apt-get install ca-certificates curl gnupg lsb-release`
  #### `sudo mkdir -p /etc/apt/keyrings`
  #### `curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg`
  #### `echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null`
  #### `sudo chmod a+r /etc/apt/keyrings/docker.gpg`
  #### `sudo apt-get update`
  #### `sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin`
  #### `sudo groupadd docker`
  #### `sudo usermod -aG docker $USER`
  #### `newgrp docker`
  #### `sudo chown "$USER":"$USER" /home/"$USER"/.docker -R`
  #### `sudo chmod g+rwx "$HOME/.docker" -R`

</ul>

---

<br/>

<h1 align="center" >How to :</h1>


<br/>
<br/>

> <h3 align="center">Start containers: <code>make start</code></h3>
> <h3 align="center">Stop containers: <code>make stop</code></h3>
> <h3 align="center">List active containers: <code>docker ps</code></h3>

---

<br/>

<h1 align="center" >How to run the application :</h1>

<br/>
<br/>

> <h3 align="center">! Run main class !</h3>
