import { useEffect, useState } from 'react'
import VehicleForm from './VehicleForm'
import { deleteVehicle } from '../../api/vehicleService'

function VehicleList({ vehicles, onVehicleCreated, onEditVehicle }) {

  const handleDelete = async (id) => {
    await deleteVehicle(id)
    onVehicleCreated()
  }
  return (
    <ul>
      {vehicles.map(vehicle => (
        <li key={vehicle.id}>
          {vehicle.patent} {vehicle.make} {vehicle.model} - {vehicle.year}

          <button onClick={() => onEditVehicle(vehicle)}>Edit</button>

          <button onClick={() => handleDelete(vehicle.id)}>Delete</button>
        </li>
      ))}
    </ul>
  )

}

export default VehicleList




/*
function VehiclesList() {

  const [vehicles, setVehicles] = useState([])

 const fetchVehicles = async () => {
  const response = await fetch(
    `http://localhost:8080/api/vehicles?page=${page}&size=5`
  )
  const data = await response.json()

  setVehicles(data.content)
  setTotalPages(data.totalPages)
}

  useEffect(() => {
    fetchVehicles()
  }, [])

  return (
    <div>
      <h2>Vehicles List</h2>

      <VehicleForm onVehicleCreated={fetchVehicles} />

      <button onClick={fetchVehicles}>
        Refresh
      </button>

      <ul>
        {vehicles.map(vehicle => (
          <li key={vehicle.id}>
            {vehicle.patent} {vehicle.make} {vehicle.model} - {vehicle.year}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default VehiclesList*/