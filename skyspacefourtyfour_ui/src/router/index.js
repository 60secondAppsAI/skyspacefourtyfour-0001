import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Flights from  '@/pages/Flights.vue';
import FlightDetail from  '@/pages/FlightDetail.vue';
import Passengers from  '@/pages/Passengers.vue';
import PassengerDetail from  '@/pages/PassengerDetail.vue';
import Tickets from  '@/pages/Tickets.vue';
import TicketDetail from  '@/pages/TicketDetail.vue';
import Airports from  '@/pages/Airports.vue';
import AirportDetail from  '@/pages/AirportDetail.vue';
import Airlines from  '@/pages/Airlines.vue';
import AirlineDetail from  '@/pages/AirlineDetail.vue';
import Luggages from  '@/pages/Luggages.vue';
import LuggageDetail from  '@/pages/LuggageDetail.vue';
import Staffs from  '@/pages/Staffs.vue';
import StaffDetail from  '@/pages/StaffDetail.vue';
import CheckIns from  '@/pages/CheckIns.vue';
import CheckInDetail from  '@/pages/CheckInDetail.vue';
import Bookings from  '@/pages/Bookings.vue';
import BookingDetail from  '@/pages/BookingDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Gates from  '@/pages/Gates.vue';
import GateDetail from  '@/pages/GateDetail.vue';
import Lounges from  '@/pages/Lounges.vue';
import LoungeDetail from  '@/pages/LoungeDetail.vue';
import Meals from  '@/pages/Meals.vue';
import MealDetail from  '@/pages/MealDetail.vue';
import BaggageClaims from  '@/pages/BaggageClaims.vue';
import BaggageClaimDetail from  '@/pages/BaggageClaimDetail.vue';
import SecurityChecks from  '@/pages/SecurityChecks.vue';
import SecurityCheckDetail from  '@/pages/SecurityCheckDetail.vue';
import Schedules from  '@/pages/Schedules.vue';
import ScheduleDetail from  '@/pages/ScheduleDetail.vue';
import Fleets from  '@/pages/Fleets.vue';
import FleetDetail from  '@/pages/FleetDetail.vue';
import Maintenances from  '@/pages/Maintenances.vue';
import MaintenanceDetail from  '@/pages/MaintenanceDetail.vue';
import Promotions from  '@/pages/Promotions.vue';
import PromotionDetail from  '@/pages/PromotionDetail.vue';
import Feedbacks from  '@/pages/Feedbacks.vue';
import FeedbackDetail from  '@/pages/FeedbackDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/flights',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/flights',
		name: 'Flights',
		layout: DefaultLayout,
		component: Flights,
	},
	{
	    path: '/flight/:flightId', 
	    name: 'FlightDetail',
		layout: DefaultLayout,
	    component: FlightDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/passengers',
		name: 'Passengers',
		layout: DefaultLayout,
		component: Passengers,
	},
	{
	    path: '/passenger/:passengerId', 
	    name: 'PassengerDetail',
		layout: DefaultLayout,
	    component: PassengerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/tickets',
		name: 'Tickets',
		layout: DefaultLayout,
		component: Tickets,
	},
	{
	    path: '/ticket/:ticketId', 
	    name: 'TicketDetail',
		layout: DefaultLayout,
	    component: TicketDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airports',
		name: 'Airports',
		layout: DefaultLayout,
		component: Airports,
	},
	{
	    path: '/airport/:airportId', 
	    name: 'AirportDetail',
		layout: DefaultLayout,
	    component: AirportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airlines',
		name: 'Airlines',
		layout: DefaultLayout,
		component: Airlines,
	},
	{
	    path: '/airline/:airlineId', 
	    name: 'AirlineDetail',
		layout: DefaultLayout,
	    component: AirlineDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/luggages',
		name: 'Luggages',
		layout: DefaultLayout,
		component: Luggages,
	},
	{
	    path: '/luggage/:luggageId', 
	    name: 'LuggageDetail',
		layout: DefaultLayout,
	    component: LuggageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/staffs',
		name: 'Staffs',
		layout: DefaultLayout,
		component: Staffs,
	},
	{
	    path: '/staff/:staffId', 
	    name: 'StaffDetail',
		layout: DefaultLayout,
	    component: StaffDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/checkIns',
		name: 'CheckIns',
		layout: DefaultLayout,
		component: CheckIns,
	},
	{
	    path: '/checkIn/:checkInId', 
	    name: 'CheckInDetail',
		layout: DefaultLayout,
	    component: CheckInDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bookings',
		name: 'Bookings',
		layout: DefaultLayout,
		component: Bookings,
	},
	{
	    path: '/booking/:bookingId', 
	    name: 'BookingDetail',
		layout: DefaultLayout,
	    component: BookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/gates',
		name: 'Gates',
		layout: DefaultLayout,
		component: Gates,
	},
	{
	    path: '/gate/:gateId', 
	    name: 'GateDetail',
		layout: DefaultLayout,
	    component: GateDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/lounges',
		name: 'Lounges',
		layout: DefaultLayout,
		component: Lounges,
	},
	{
	    path: '/lounge/:loungeId', 
	    name: 'LoungeDetail',
		layout: DefaultLayout,
	    component: LoungeDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/meals',
		name: 'Meals',
		layout: DefaultLayout,
		component: Meals,
	},
	{
	    path: '/meal/:mealId', 
	    name: 'MealDetail',
		layout: DefaultLayout,
	    component: MealDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/baggageClaims',
		name: 'BaggageClaims',
		layout: DefaultLayout,
		component: BaggageClaims,
	},
	{
	    path: '/baggageClaim/:baggageClaimId', 
	    name: 'BaggageClaimDetail',
		layout: DefaultLayout,
	    component: BaggageClaimDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/securityChecks',
		name: 'SecurityChecks',
		layout: DefaultLayout,
		component: SecurityChecks,
	},
	{
	    path: '/securityCheck/:securityCheckId', 
	    name: 'SecurityCheckDetail',
		layout: DefaultLayout,
	    component: SecurityCheckDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/schedules',
		name: 'Schedules',
		layout: DefaultLayout,
		component: Schedules,
	},
	{
	    path: '/schedule/:scheduleId', 
	    name: 'ScheduleDetail',
		layout: DefaultLayout,
	    component: ScheduleDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/fleets',
		name: 'Fleets',
		layout: DefaultLayout,
		component: Fleets,
	},
	{
	    path: '/fleet/:fleetId', 
	    name: 'FleetDetail',
		layout: DefaultLayout,
	    component: FleetDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/maintenances',
		name: 'Maintenances',
		layout: DefaultLayout,
		component: Maintenances,
	},
	{
	    path: '/maintenance/:maintenanceId', 
	    name: 'MaintenanceDetail',
		layout: DefaultLayout,
	    component: MaintenanceDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/promotions',
		name: 'Promotions',
		layout: DefaultLayout,
		component: Promotions,
	},
	{
	    path: '/promotion/:promotionId', 
	    name: 'PromotionDetail',
		layout: DefaultLayout,
	    component: PromotionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/feedbacks',
		name: 'Feedbacks',
		layout: DefaultLayout,
		component: Feedbacks,
	},
	{
	    path: '/feedback/:feedbackId', 
	    name: 'FeedbackDetail',
		layout: DefaultLayout,
	    component: FeedbackDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
