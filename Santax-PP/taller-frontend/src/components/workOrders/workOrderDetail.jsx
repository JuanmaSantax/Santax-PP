import { useState } from "react";

function WorkOrderDatail({ order, onUpdate }){
    const [newArea, setNewArea] = useState("");
    const [newAdjustment, setNewAdjustment] = useState({tinta: "", cantidad: ""});

    return (
        <div style={{ border: "2px solid #27ae60", padding: "20px", borderRadius: "8px", backgroundColor: "#f9f9f9", color: "#333" }}>
      <h2>Orden de Trabajo #{order.id}</h2>
      <p><strong>Descripción:</strong> {order.generalDescription}</p>
      <p><strong>Fecha Ingreso:</strong> {order.entryDate}</p>

      <hr />

      <div style={{ display: "flex", gap: "20px" }}>
        {/* SECCIÓN ÁREAS REPARADAS */}
        <div style={{ flex: 1 }}>
          <h3>🛠️ Áreas a Reparar</h3>
          <ul>
            {order.repairedAreas?.map((area) => (
              <li key={area.id}>{area.description}</li>
            ))}
          </ul>
          <input 
            type="text" 
            placeholder="Ej: Guardabarros" 
            value={newArea} 
            onChange={(e) => setNewArea(e.target.value)} 
          />
          <button onClick={() => alert("Llamar API para guardar área")}>Añadir</button>
        </div>

            {/* Seccion ajuste de color a mejorar*/}
        <div style={{ flex: 1 }}>
          <h3>🎨 Ajuste de Color</h3>
          <ul>
            {order.colorAdjustments?.map((adj) => (
              <li key={adj.id}>{adj.tintName}: {adj.amount}gr</li>
            ))}
          </ul>
          <input 
            placeholder="Tinta" 
            onChange={(e) => setNewAdjustment({...newAdjustment, tinta: e.target.value})} 
          />
          <input 
            placeholder="Gramos" 
            type="number" 
            onChange={(e) => setNewAdjustment({...newAdjustment, cantidad: e.target.value})} 
          />
          <button onClick={() => alert("Llamar API para guardar ajuste")}>Registrar Mezcla</button>
        </div>
      </div>
    </div>

    )
} 

export default WorkOrderDatail;