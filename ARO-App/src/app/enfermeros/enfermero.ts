export class Enfermero{

    constructor(
        public id: number,
        public nombre: string,
        public apellido: string,
        public fechaAlta: Date,
        public tipoDocumento: string,
        public nroDocumento: number,
        public fechaNacimiento: Date,
        public lugarNacimiento: string,
        public telefono: number,
        public edad: number,
        public nroMatricula: number,
        public estado: string   

    ){}

}