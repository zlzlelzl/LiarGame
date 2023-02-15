FROM node:14

WORKDIR /root/***REMOVED***/front-end

COPY ./ ./

RUN npm install

RUN npm run build

COPY ./ ./