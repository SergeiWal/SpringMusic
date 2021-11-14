const playlist = {
    name: "",
    songs:[]
}

const songs = [];
const ownerId = 2;

document.addEventListener('click',(e)=>{
    const object = e.target;
    if(object.classList.contains("song_button")){
        e.preventDefault();
        const songId = object.getAttribute("src");
        if(!object.classList.contains("active")){
            songs.push(songId);
            object.classList.add("active");
        }else{
            const index = songs.indexOf(songId);
            songs.splice(index,1);
            object.classList.remove("active");
        }

    }else if(object.classList.contains("save_btn")){
        e.preventDefault();
        const name = document.querySelector("#playlistName").value;
        playlist.name = name;
        //console.log(playlist);
        fetch(`http://localhost:8083/playlists/${ownerId}`,{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(playlist)
        })
            .then(request=>request.json())
            .then(data=>{
                //console.log(data);
                addSongs(data.id);
                document.location.reload();
            })
            .catch(err=>console.log(err));
    }
})

function addSongs(playlistId){
    for(let song of songs){
        fetch(`http://localhost:8083/playlists/${playlistId}/songs/${song}`,{method:"POST"}).catch(err=>console.log(err));
    }
}