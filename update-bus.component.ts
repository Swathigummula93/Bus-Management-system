import { Component } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusServiceService } from '../bus-service.service';

@Component({
  selector: 'app-update-bus',
  templateUrl: './update-bus.component.html',
  styleUrls: ['./update-bus.component.css']
})
export class UpdateBusComponent {
  bus_Id: number = 0;
  bus: Bus = new Bus();
  constructor(private busService: BusServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.bus_Id = this.route.snapshot.params['bus_Id'];  

    this.busService.getBusById(this.bus_Id).subscribe((data: Bus) => {
      this.bus = data;
    }, (error: any) => console.log(error));
  }

  onSubmit(){
    this.busService.updateBus(this.bus_Id, this.bus).subscribe( () =>{
      this.getAllBusDetails();
    }
    , (error: any) => console.log(error));
  }

  getAllBusDetails(){
    this.router.navigate(['buses']);
  }
}

