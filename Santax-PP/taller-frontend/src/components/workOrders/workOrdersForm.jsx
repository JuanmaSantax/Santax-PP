import { useState } from "react";
import { createWorkOrder } from "../../api/workOrderService";

 function WorkOrdersForm({ vehicleId, onWorkOrderCreated }) {
    const [formData, setFormData] = useState({
        generalDescription: "",
        entryDate: ""
    });

    const [error, setError] = useState("")
    const handleChange = (e) => {
        const { name, value } = e.target;
        
        setFormData((prev => ({
            ...prev,
            [name]: value
        })))
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        if(!formData.generalDescription || !formData.entryDate) {
            setError("Todos los campos son obligatorios")
            return;
        }
    try {

         await createWorkOrder({...formData, vehicleId: vehicleId})

        setFormData({generalDescription: "", entryDate: ""})
        setError("")

        if(onWorkOrderCreated) {
            onWorkOrderCreated()
        }
        } catch (err) {
            console.error(err);
            setError("Error al crear la orden de trabajo")
        }
    }    
    return (
        <form onSubmit={handleSubmit} style={{marginBottom: "10px"}}> 
            <h4> Add work order</h4>

            {error && <p style={{color: "red"}}>{error}</p>}

            <div>
                <input type="text"  name="generalDescription" placeholder='¿Que paso? "Palo de frente"' value={formData.generalDescription} onChange={handleChange}/>
            </div>
             <div>
                <input type="date"  name="entryDate"  value={formData.entryDate} onChange={handleChange}/>
            </div>

            <button type="submit">Create work order</button>

         </form>
    )       
} 

export default WorkOrdersForm;