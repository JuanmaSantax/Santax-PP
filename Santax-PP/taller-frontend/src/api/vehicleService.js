const API_URL = 'http://localhost:8080/vehicles';

export const getVehicles = async (page, size) => {
    const response = await fetch(`${API_URL}?page=${page}&size=${size}`)
    return response.json();
}

export const createVehicle = async (vehicle) => {
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(vehicle)
    });
    return response.json();
}

export const deleteVehicle = async (id) => {
  await fetch(`http://localhost:8080/vehicles/${id}`, {
    method: "DELETE"
  })
}

export const updateVehicle = async (id, vehicle) => {
    const response = await fetch(`http://localhost:8080/vehicles/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },  
        body: JSON.stringify(vehicle)
    });
    return response.json();
}