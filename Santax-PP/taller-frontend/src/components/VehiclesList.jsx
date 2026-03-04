import { useEffect, useState } from 'react'

function VehiclesList() {
  const [vehicles, setVehicles] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/api/vehicles')
            .then(response => response.json())
            .then(data =>{
                setVehicles(data.content)
            })
    }, [])

  return (
    <div>
        <h2>Vehicles List</h2>
        <ul>
            {vehicles.map(vehicle => (
                <li key={vehicle.id}>{vehicle.patent}{vehicle.make} {vehicle.model} - {vehicle.year}</li>
            ))}
        </ul>
    </div>
  )
}

export default VehiclesList