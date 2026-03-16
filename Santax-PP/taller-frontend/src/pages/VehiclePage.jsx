import { useEffect, useState } from "react"
import VehicleForm from "../components/vehicles/VehicleForm"  
import VehicleList from "../components/vehicles/VehiclesList"
import { getVehicles } from "../api/vehicleService"

function VehiclesPage() {

  const [vehicles, setVehicles] = useState([])
  const [page, setPage] = useState(0)
  const [totalPages, setTotalPages] = useState(0)
  const [editVehicle, setEditVehicle] = useState(null)


  const fetchVehicles = async () => {
    const response = await fetch(
      `http://localhost:8080/vehicles?page=${page}&size=5`
    )

    const data = await getVehicles(page, 5)

    setVehicles(data.content)
    setTotalPages(data.totalPages)
  }

  useEffect(() => {
    fetchVehicles()
  }, [page])

  return (
    <div>

      <h1>Vehicles</h1>

      <VehicleForm editVehicle={editVehicle}
       onVehicleSaved={() => setEditVehicle(null)}
       fetchVehicles={fetchVehicles}
       /* onVehicleCreated={fetchVehicles}*/ />

      <VehicleList vehicles={vehicles}
      onVehicleDeleted={fetchVehicles}
      onEditVehicle={setEditVehicle}
       /*onVehicleCreated={fetchVehicles} *//>

      <div>

        <button
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
        >
          Previous
        </button>

        <span> Page {page + 1} of {totalPages} </span>

        <button
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
        >
          Next
        </button>

      </div>

    </div>
  )
}

export default VehiclesPage