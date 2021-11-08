const rootPath = "E:/GIT/Music/";

document.addEventListener("click",(e)=>{

   const target = e.target;
    if(target.classList.contains("save_btn")){
        e.preventDefault();
        const name = document.querySelector("#songName").value;
        const author = document.querySelector("#songAuthor").value;
        const album = document.querySelector("#songAlbum").value;
        const genre = document.querySelector("#songGenre").value;
        const source = rootPath +  document.querySelector("#songSource").files[0].name;
        const body = {
            name,author,album,genre,source,
            rating: 0
        };
        fetch("http://localhost:8083/songs",{
            method: "POST",
            body: JSON.stringify(body),
            headers: {"Content-Type":"application/json"}
        }).then(response=>response.json()).then(data=>console.log(data)).catch(err=>console.log(err));
   }
});