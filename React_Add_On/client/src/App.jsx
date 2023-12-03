import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [light, setLight] = useState(false)
  // const light = false;
  return (
    <>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        </div>
        <div style={{display:"flex"}}>
          <button style={{border:"2px solid black",background:"lightblue", margin:"10px", width:"200px"}} onClick={() => setLight((light) => !light)}>
          {light?
            <p style={{color:"red"}}>Click For Red</p>
            :
            <p style={{color:"green"}}>Click For Green</p>
          }
          </button>
          {light?
            <p style={{width:"60px",height:"60px", borderRadius:"50%",background:"green",color:"white",display:"flex",alignItems:"center",justifyContent:"center"}}>GREEN</p>
            :
            <p style={{width:"60px",height:"60px", borderRadius:"50%",background:"red",color:"white",display:"flex",alignItems:"center",justifyContent:"center"}}>RED</p>
          }
        </div>
    </>
  )
}

export default App
