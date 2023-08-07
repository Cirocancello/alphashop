import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  userId: string = "Ciro";
  password: string = "";

  autenticato: boolean = true;
  consentito: boolean = true;
  errMsg: string = "Spiacenti, la sua userId e/o password sono errarte!";
  okMsg: string = "Accesso consentito";

  ngOnInit(): void {   
  }

   getsAuth = (): void => {
    if(this.userId === "Ciro" && this.password === "123"){
      this.autenticato = true;
      this.consentito = true;
    }
   else{
      this.autenticato = false;
      this.consentito = false;  
   }

  }
}
