public enum categoriaVinho {
    SIMPLES, 
    ELABORADO,
    PREMIUM; 

    public  categoriaVinho parseCategoriaVinho(String categoria){ 
        switch(categoria.toLowerCase()){ 
            case "simples": return SIMPLES; 
            case "elaborado": return ELABORADO; 
            case "premium": return PREMIUM; 
            default: return null; 
        }
    }
}
