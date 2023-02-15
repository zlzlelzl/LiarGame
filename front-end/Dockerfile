FROM node:14

WORKDIR /root/***REMOVED***/front-end

COPY package.json ./
COPY package-lock.json ./

RUN npm install

COPY ./ ./

CMD ["npm", "run", "build"]
