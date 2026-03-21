const API_URL = "http://localhost:8080/repairedAreas";

export const addRepairedArea = async (areaData) => {
    const response = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(areaData)
    });
    return await response.json();
};