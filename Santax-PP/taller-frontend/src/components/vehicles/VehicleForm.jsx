import { useState, useEffect } from "react"
import { createVehicle, updateVehicle } from "../../api/vehicleService"

function VehicleForm({ editingVehicle, onVehicleSaved }) {

  const [formData, setFormData] = useState({
    patent: "",
    make: "",
    model: "",
    originalColorCode: "",
    year: ""
  })

  const [error, setError] = useState("")

  // Cuando se presiona EDIT en la lista
  useEffect(() => {
    if (editingVehicle) {
      setFormData({
        patent: editingVehicle.patent || "",
        make: editingVehicle.make || "",
        model: editingVehicle.model || "",
        originalColorCode: editingVehicle.originalColorCode|| "",
        year: editingVehicle.year || ""
      })
    }
  }, [editingVehicle])

  const handleChange = (e) => {
    const { name, value } = e.target

    setFormData(prev => ({
      ...prev,
      [name]: value
    }))
  }

  const handleSubmit = async (e) => {
    e.preventDefault()

    if (!formData.patent || !formData.make || !formData.model || !formData.year ) {
      setError("All fields are required")
      return
    }

    try {

      if (editingVehicle) {

        await updateVehicle(editingVehicle.id, {
          ...formData,
          year: Number(formData.year)
        })

      } else {

        await createVehicle({
          ...formData,
          year: Number(formData.year)
        })

      }

      setFormData({
        patent: "",
        make: "",
        model: "",
        originalColorCode: "",
        year: ""
      })

      setError("")

      if (onVehicleSaved) {
        onVehicleSaved()
      }

    } catch (err) {
      console.error(err)
      setError("Error saving vehicle")
    }
  }

  return (
    <form onSubmit={handleSubmit}>

      <h3>{editingVehicle ? "Update Vehicle" : "Create Vehicle"}</h3>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <div>
        <input
          name="patent"
          placeholder="Patent"
          value={formData.patent}
          onChange={handleChange}
        />
      </div>

      <div>
        <input
          name="make"
          placeholder="Make"
          value={formData.make}
          onChange={handleChange}
        />
      </div>

      <div>
        <input
          name="model"
          placeholder="Model"
          value={formData.model}
          onChange={handleChange}
        />
      </div>
    <div>
        <input
          name="originalColorCode"
          type="text"
          placeholder="Color Code"
          value={formData.originalColorCode}
          onChange={handleChange}
        />
    </div>
      <div>
        <input
          name="year"
          type="number"
          placeholder="Year"
          value={formData.year}
          onChange={handleChange}
        />
      </div>

      <button type="submit">
        {editingVehicle ? "Update Vehicle" : "Create Vehicle"}
      </button>

    </form>
  )
}

export default VehicleForm