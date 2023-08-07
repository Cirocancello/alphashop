import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  userId: string = "Ciro";
  password: string = "";

  autenticato: boolean = true;
  
  errMsg: string = "Spiacenti, la sua userId e/o password sono errarte!";
  
  titolo: string = "Accesso & Autenticazione";
  sottotitolo: string = "Procedi ad inserire la userid e la password";

  constructor(private route: Router){}

  ngOnInit(): void {   
  }

   getsAuth = (): void => {
    if(this.userId === "Ciro" && this.password === "123"){
      this.route.navigate(['welcome', this.userId])
      this.autenticato = true;
     
    }
   else{
      this.autenticato = false;
      
   }

  }
}
