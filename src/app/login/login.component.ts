import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthappService } from 'src/service/authapp.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  userId: string = "";
  password: string = "";

  autenticato: boolean = true;
  
  errMsg: string = "Spiacenti, la sua userId e/o password sono errarte!";
  
  titolo: string = "Accesso & Autenticazione";
  sottotitolo: string = "Procedi ad inserire la userid e la password";

  constructor(private route: Router, private BasicAuth: AuthappService){}

  ngOnInit(): void {   
  }

   gestAuth = (): void => {
    if(this.BasicAuth.autentica(this.userId, this.password)){
      this.route.navigate(['welcome', this.userId])
      this.autenticato = true;
     
    }
   else{
      this.autenticato = false;
      
   }

  }
}
