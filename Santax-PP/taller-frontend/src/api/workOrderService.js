const API_URL = "http://localhost:8080/workorders"

export const createWorkOrder = async (workOrder) => {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(workOrder)
  })

  return response.json()
}

export const getWorkOrdersByVehicle = async (vehicleId) => {
  const response = await fetch(`${API_URL}/vehicle/${vehicleId}`)
  return response.json()
}