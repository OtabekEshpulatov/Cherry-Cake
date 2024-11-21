// src/store/index.js
import { createStore } from 'vuex';

const store = createStore({
    state() {
        return {
            TopProducts: [
                {
                    id: 1,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 2,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 3,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 4,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 5,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 6,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 7,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },
                {
                    id: 8,
                    name: 'Latte',
                    picture: 'https://i.pinimg.com/originals/81/9a/cc/819accc6ae855fdea58b4759c72e0c3b.jpg',
                    size: '200 ml',
                    imgDesc: 'Latter image',
                    price: '5',
                    description: ` A latte typically contains one or two shots of espresso, several ounces of steamed milk, and a thin layer of foam.`
                },

            ],
            AllProducts: [
                {
                    id: 1,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 5,
                    description: `This moist and delicious gluten-friendly cake is made with fresh strawberries mixed into the icing.
                    Some say it's great for birthdays, anniversaries, weddings, and other special occasions
                    This moist cake is made without artificial colors, flavors, or mixes and is full of strawberry flavor.
                    It's topped with strawberry cream cheese frosting and fresh strawberries`
                },
                {
                    id: 2,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 4,
                    description: ''
                },
                {
                    id: 3,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 4,
                    description: ''
                },
                {
                    id: 4,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 4,
                    description: ''
                },
                {
                    id: 5,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 4,
                    description: ''
                },
                {
                    id: 6,
                    name: 'Brownie',
                    picture: 'https://img.freepik.com/free-photo/sugar-sprinkle-chocolate-waffle-board-blue-background_114579-39710.jpg',
                    imgDesc: 'Brownie image',
                    price: '7',
                    raiting: 4,
                    description: ''
                },
            ],
            OrderDetails: {
                quantity: 1,
                region: 'EN',
                date: '2024/10/01',
                totalPrice:'14.5'
            }
        };
    },
    mutations: {

    },
    actions: {

    },
    getters: {
        getTopProducts(state) {
            return state.TopProducts
        },
        getAllProducts(state) {
            return state.AllProducts
        }
    },
});

export default store;