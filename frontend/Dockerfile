FROM node:alpine

WORKDIR ./
COPY ./package.json ./
COPY ./babel.config.js ./
RUN ["npm",  "--legacy-peer-deps", "install"]

COPY ./public ./public
COPY ./src ./src
COPY  ./vue.config.js ./
RUN ["npm", "install", "--legacy-peer-deps", "@vue/cli-service"]
RUN ["npm", "run", "build"]

EXPOSE 4050/tcp
CMD ["npm", "run", "serve"]
