const API_URL = "http://localhost:8080/colorAdjustments";

export const addColorAdjustment = async (colorData) => {
    const response = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(colorData)
    });
    return response.json();

}