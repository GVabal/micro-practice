# stage 1

FROM node:alpine AS my-app-build
WORKDIR /app
COPY . .
RUN npm ci && npm run build

# stage 2

FROM nginx:1.17.1-alpine
COPY --from=my-app-build /app/dist/ui /usr/share/nginx/html