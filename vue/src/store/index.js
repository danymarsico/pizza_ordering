import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    
    pizza: {
      pizzaId: 0,
      pizzaSize: '',
      pizzaCrust: '',
      pizzaSauce: '',
      selectedToppings: [],
      pizzaPrice: 0.00,
      pizzaName: '',
      additionalInfo: ''

    },
    cart: [

    ],
    specialtyPizzas: [
      {
        pizzaName: 'The Butcher',
        price: 17.00,
        desc:'Immerse yourself in the neon-lit allure of "The Butcher" – a carnivore\'s paradise orchestrating a symphony of prosciutto, pepperoni, sausage, and ham, dancing flawlessly on a hand-stretched dough stage. Every savory bite propels you through a time-traveling adventure, capturing the glitchy indulgence of these meaty constellations orbiting a molten mozzarella universe. This slice of vaporwave-inspired delight propels your taste buds into a retro-futuristic escapade, evoking a wave of nostalgia with each flavorful sensation.',
        specialtyToppings:['Cheese', 'Prosciutto', 'Sausage', 'Ham', 'Pepperoni'],
        imgsrc: require('@/assets/butcher.png')
      },
      {
        pizzaName: 'The G.O.A.T.',
        price: 17.00,
        desc:'Venture into the kaleidoscopic domain of "The G.O.A.T." – a vegetarian masterpiece harmonizing olives, green peppers, onions, and chanterelle mushrooms on a skillfully stretched dough canvas. Each delectable bite unfolds a journey across a vivid garden, as these vibrant ingredients unite beneath a blanket of melted mozzarella. Embark on a taste-packed odyssey that defies the constraints of time, capturing the essence of retro-futuristic aesthetics while embracing the exquisite flavors of nature\'s harvest.',
        specialtyToppings:['Cheese', 'Olives', 'Green Peppers', 'Onions', 'Chanterelle Mushrooms'],
        imgsrc: require('@/assets/goat.png')
      },
      {
        pizzaName: 'O.G. NAMELESS',
        price: 33.25,
        desc:'Indulge in a world of culinary opulence with the "O.G. Nameless" – an original creation that transcends conventional boundaries, adorned with the luxurious flavors of black truffle and the regal charm of edible gold leaf. Envision a hand-stretched dough canvas where these lavish elements unite in flawless harmony, crafting a gastronomic marvel worthy of royalty. With each delectable bite, you\'re transported to a realm of refined flavors and timeless elegance, as the "O.G. Nameless" encapsulates opulence within a single, unforgettable slice.',
        specialtyToppings:['Cheese', 'Gold Leaf', 'Black Truffle'],
        imgsrc: require('@/assets/ognameless.png')
      },
      {
        pizzaName: 'Playlist Deluxe',
        price: 18.25,
        desc:'Step into a symphony of taste with the "Playlist Deluxe" – a deluxe pizza that harmonizes succulent Italian sausage, robust pepperoni, caramelized onions, roasted green peppers, and earthy mushrooms beneath a golden canopy of melted mozzarella on a meticulously hand-stretched dough canvas. Imagine relishing the opulent blend of these premium ingredients, expertly orchestrated to create a culinary masterpiece that embodies both indulgence and sophistication. With every sumptuous bite, you\'re invited to experience a culinary symphony akin to a lavishly orchestrated musical opus, as the "Playlist Deluxe" guides your taste buds through the pinnacle of flavor and lavishness.',
        specialtyToppings:['Cheese', 'Sausage', 'Pepperoni', 'Onions', 'Green Peppers', 'Chanterelle Mushrooms'],
        imgsrc: require('@/assets/playlistdeluxe.png')
      },
      {
        pizzaName: 'Custom Pizza',
        price: 10.00,
        desc:'Embark on a neon-infused flavor odyssey with "Create Your Own" – an edible artist\'s playground where every topping combination becomes a work of vaporwave-inspired culinary art. Unleash your taste bud creativity and curate a symphony of flavors that defy convention and tantalize the senses. From pixelated pepperoni to glitched-out gold leaf, this customizable adventure invites you to sculpt your own taste masterpiece in a kaleidoscope of delicious possibilities',
        specialtyToppings:'Add your toppings',
        imgsrc: require('@/assets/emptypizzacrust.jpg')
      }
    ],
    toppings: [
      {
        toppingName: 'Cheese',
        toppingPrice: 1.00,
        isPremium: false,
      },
      {
        toppingName: 'Pepperoni',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Sausage',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Ham',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Olives',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Green Peppers',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Onions',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Eggs',
        toppingPrice: 1.25,
        isPremium: false,
      },
      {
        toppingName: 'Gold Leaf',
        toppingPrice: 20.00,
        isPremium: true,
      },      
      {
        toppingName: 'Chanterelle Mushrooms',
        toppingPrice: 2.25,
        isPremium: true,
      },
      {
        toppingName: 'Prosciutto',
        toppingPrice: 2.25,
        isPremium: true,
      },
      {
        toppingName: 'Black Truffle',
        toppingPrice: 2.25,
        isPremium: true,
      },
    ],

    size: [
      {
        sizeName: 'Small',
        sizePrice: 10.00
      },
      {
        sizeName: 'Medium',
        sizePrice: 14.00
      },
      {
        sizeName: 'Large',
        sizePrice: 18.00
      },
    ],
    
    sauce: [
      {
        sauceName: 'None',
        saucePrice: 0.00
      },
      {
        sauceName: 'Tomato',
        saucePrice: 0.00
      },
      {
        sauceName: 'Pesto',
        saucePrice: 0.75
      },
      {
        sauceName: 'Buffalo',
        saucePrice: 0.75
      },
      {
        sauceName: 'White Garlic',
        saucePrice: 0.75
      },
    ],

    crust: [
      {
        crustName: 'Hand Tossed',
        crustPrice: 0.00
      },
      {
        crustName: 'Thin',
        crustPrice: 0.00
      },
      {
        crustName: 'Pan',
        crustPrice: 1.00
      },
      {
        crustName: 'Stuffed',
        crustPrice: 2.00
      },
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_TO_CART(state, payload) {
      let pizza = {};
      pizza.pizzaSize = payload.selectedSize;
      pizza.pizzaCrust = payload.selectedCrust;
      pizza.pizzaSauce = payload.selectedSauce;
      pizza.pizzaName = payload.selectedPizza;
      pizza.additionalInfo = payload.additionalInfo;
      pizza.selectedToppings = payload.selectedToppings;
      pizza.price = payload.price;

      state.cart.push(pizza);
    },
  }
})
